package cs1635.group.booksharing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDBHelper extends SQLiteOpenHelper {
	public static final String TABLE_BOOKS = "Books";
	public static final String TABLE_BOOKS_FTS = "Books_FTS";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_ISBN = "isbn";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_AUTHOR = "author";
	public static final String COLUMN_SUBJECT = "subject";
	public static final String COLUMN_PRICE = "price";
	public static final String COLUMN_SELLER = "seller";
	
	private static final String DATABASE_NAME = "Books.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "CREATE TABLE "
			+ TABLE_BOOKS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COLUMN_ISBN + " CHAR(13) NOT NULL, "
			+ COLUMN_TITLE + " VARCHAR(128) NOT NULL, "
			+ COLUMN_AUTHOR + " VARCHAR(32) NOT NULL, "
			+ COLUMN_SUBJECT + " VARCHAR(16) NOT NULL, "
			+ COLUMN_PRICE + " VARCHAR(8) NOT NULL, "
			+ COLUMN_SELLER + " VARCHAR(16) NOT NULL);";
	
	public BookDBHelper (Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		db.execSQL("CREATE INDEX IF NOT EXISTS IDX_BOOKS_ISBN ON " + TABLE_BOOKS + " (" + COLUMN_ISBN + ")");
		db.execSQL("CREATE INDEX IF NOT EXISTS IDX_BOOKS_TITLE ON " + TABLE_BOOKS + " (" + COLUMN_TITLE + ")");
		db.execSQL("CREATE INDEX IF NOT EXISTS IDX_BOOKS_AUTHOR ON " + TABLE_BOOKS + " (" + COLUMN_AUTHOR + ")");
		db.execSQL("CREATE INDEX IF NOT EXISTS IDX_BOOKS_SUBJECT ON " + TABLE_BOOKS + " (" + COLUMN_SUBJECT + ")");
		db.execSQL("CREATE VIRTUAL TABLE " + TABLE_BOOKS_FTS + " USING fts3(" + COLUMN_ID + ", "
				+ COLUMN_ISBN + ", " + COLUMN_TITLE + ", " + COLUMN_AUTHOR + ", " + COLUMN_SUBJECT
				+ ", " + COLUMN_PRICE + ", " + COLUMN_SELLER + ");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS_FTS);
		onCreate(db);
	}
}
