package db.migration

import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SingleConnectionDataSource
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import java.nio.charset.StandardCharsets
import javax.sql.DataSource


class V2__update_book : BaseJavaMigration() {
    override fun migrate(context: Context?) {
        val singleConnectionDataSource = SingleConnectionDataSource(context!!.connection, true)
        val jdbcTemplate = JdbcTemplate(singleConnectionDataSource)

        jdbcTemplate.execute("USE flyway_test")
        jdbcTemplate.execute(
            "CREATE TABLE books\n" +
                    "(\n" +
                    "    books_id BIGINT NOT NULL auto_increment,\n" +
                    "    name     VARCHAR(64),\n" +
                    "    author   VARCHAR(64),\n" +
                    "    PRIMARY KEY (books_id)\n" +
                    "\n" +
                    ");"
        )
        jdbcTemplate.execute("insert into books(name, author) values(\"inittest\" , \"initetests\")")


        val rdp = ResourceDatabasePopulator()
        rdp.addScript(ClassPathResource("db/migration/test.sql"))
        rdp.execute(singleConnectionDataSource)
    }

}