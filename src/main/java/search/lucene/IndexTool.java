package search.lucene;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import search.domain.Paper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IndexTool {
    private List<Paper> papers;
    private List<Document> documentList;

    public IndexTool(List<Paper> papers) {
        this.papers = papers;
        createIndex();
    }

    private void createIndex() {
        documentList = new ArrayList<Document>();
        Document document;
        for (Paper p : papers) {
            document = new Document();
            document.add(new Field("name",p.getName(),TextField.TYPE_STORED));
            document.add(new Field("firstAuthor",p.getFirstAuthor(),TextField.TYPE_STORED));
            document.add(new Field("otherAuthor", p.getOtherAuthor(),TextField.TYPE_STORED));
            document.add(new Field("journal", p.getJournal(), TextField.TYPE_STORED));
            document.add(new Field("tTime",p.gettTime(),TextField.TYPE_STORED));
            document.add(new Field("fTime", p.getfTime(), TextField.TYPE_STORED));
            document.add(new Field("area", p.getArea(), TextField.TYPE_STORED));
            document.add(new Field("keyword", p.getKeyWord(), TextField.TYPE_STORED));
            document.add(new Field("abstract", p.getAbtract(), TextField.TYPE_STORED));
            document.add(new Field("content",p.getContent(),TextField.TYPE_STORED));
            document.add(new Field("cite", p.getCite(), TextField.TYPE_STORED));
            documentList.add(document);
        }
    }

    public void writeIndex(String path) {
        IndexWriter indexWriter = null;
        Directory directory = null;
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new SmartChineseAnalyzer());
        try {
            Path p = Paths.get(path);
            directory = new SimpleFSDirectory(p);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
            indexWriter.deleteAll();
            for (Document document : documentList) {
                indexWriter.addDocument(document);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (indexWriter != null){
                try {
                    indexWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (directory != null) {
                try {
                    directory.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
