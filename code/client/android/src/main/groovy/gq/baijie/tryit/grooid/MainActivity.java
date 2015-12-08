package gq.baijie.tryit.grooid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import groovy.lang.GroovyObject;
import groovy.lang.GroovySystem;
import groovy.lang.MetaClass;
import groovy.lang.MetaMethod;
import groovy.lang.MetaProperty;

public class MainActivity extends AppCompatActivity {

    private TextView mMainTextView;

    public void doTry() {
        final TestGroovyClass testGroovyClass = new TestGroovyClass();
        testGroovyClass.setName("Bai Jie");
        mMainTextView.append(testGroovyClass.getName() + "\n");
        mMainTextView.append(testGroovyClass.hello() + "\n");
        // call from POGO
        mMainTextView.append("[POGO]tryMetaProgrammingWithCompileDynamic:\n");
        mMainTextView.append(testGroovyClass.tryMetaProgrammingWithCompileDynamic() + "\n");
        mMainTextView.append("[POGO]tryMetaProgramming:\n");
        mMainTextView.append(testGroovyClass.tryMetaProgramming() + "\n");
        mMainTextView.append("[POGO]tryMetaProgrammingWithGetProperty:\n");
        mMainTextView.append(testGroovyClass.tryMetaProgrammingWithGetProperty() + "\n");
        // call from POJO
        mMainTextView.append("[POJO]tryMetaProgramming:\n");
        mMainTextView.append(tryMetaProgramming() + "\n");
        mMainTextView.append("[POJO]tryMetaProgrammingWithGetMetaProperty1:\n");
        mMainTextView.append(tryMetaProgrammingWithGetMetaProperty1() + "\n");
        mMainTextView.append("[POJO]tryMetaProgrammingWithGetMetaProperty2:\n");
        mMainTextView.append(tryMetaProgrammingWithGetMetaProperty2() + "\n");
        mMainTextView.append("[POJO]tryMetaProgrammingWithGetMetaProperty3:\n");
        mMainTextView.append(tryMetaProgrammingWithGetMetaProperty3() + "\n");
        mMainTextView.append("[POJO]tryMetaProgrammingWithGetProperty:\n");
        mMainTextView.append(tryMetaProgrammingWithGetProperty() + "\n");
        mMainTextView.append("\n");
    }

    private String tryMetaProgramming() {
        return Book.createWithMetaProgramming().getTitleUp();
    }

    // see http://stackoverflow.com/questions/32350797/adding-methods-to-a-class-using-groovy-in-java#answer-32354284
    private Object tryMetaProgrammingWithGetMetaProperty1() {
        MetaProperty titleUpMetaProperty = GroovySystem.getMetaClassRegistry()
                .getMetaClass(Book.class).getMetaProperty("titleUp");
        return titleUpMetaProperty.getProperty(Book.createWithMetaProgramming());
    }

    private Object tryMetaProgrammingWithGetMetaProperty2() {
        Book book = Book.createWithMetaProgramming();
        MetaProperty metaClassMetaProperty = GroovySystem.getMetaClassRegistry()
                .getMetaClass(Book.class).getMetaProperty("metaClass");
        MetaClass metaClass = (MetaClass) metaClassMetaProperty.getProperty(book);
        return metaClass.getMetaProperty("titleUp").getProperty(book);
    }

    private Object tryMetaProgrammingWithGetMetaProperty3() {
        Book book = Book.createWithMetaProgramming();
        MetaMethod getPropertyMetaMethod = GroovySystem.getMetaClassRegistry()
                .getMetaClass(Book.class).getMetaMethod("getProperty", new Object[]{String.class});
        return getPropertyMetaMethod.invoke(book, new Object[]{"titleUp"});
    }

    // don't recommend
    // see http://stackoverflow.com/questions/4139665/groovy-application-classes-and-java-unit-tests#answer-4147125
    private Object tryMetaProgrammingWithGetProperty() {
        return ((GroovyObject) Book.createWithMetaProgramming()).getProperty("titleUp");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainTextView = (TextView) findViewById(R.id.main_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doTry();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
