package db.migration

import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context

class V3__bulk_update_books : BaseJavaMigration() {
    override fun migrate(context: Context) {
        context.connection.createStatement().use { select ->
            select.executeQuery("SELECT id FROM books ORDER BY id").use { rows ->
                while (rows.next()) {
                    val id = rows.getInt(1)
                    val nameToChange = "홍길동"
                    context.connection.createStatement()
                        .use { update -> update.execute("UPDATE books SET name='$nameToChange' WHERE id=$id") }
                }
            }
        }

    }
}