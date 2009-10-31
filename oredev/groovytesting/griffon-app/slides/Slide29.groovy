import net.miginfocom.swing.MigLayout

def script = '''import org.dbunit.*
import org.junit.*

class MyDBTestCase {
   IDatabaseTester db

   @BeforeClass void init(){ 
      db = new JdbcDatabaseTester("org.hsqldb.jdbcDriver",
            "jdbc:hsqldb:sample", "sa", "" )
      def dataset = new MarkupBuilder().dataset {
         company( name: Acme )
         employee( name: "Duke", company_id: 1 )
      }
      db.dataset = new FlatXmlDataSet( new StringReader(dataset) )
      db.onSetUp()
   }

   @AfterClass void exit() { db.onTearDown() }
}'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Compile Checked Dataset") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script, runnable: false))
    }
}