/*
»» User membership creation and extension.
»» Searching the database of books
»» Reading the books
*/
public class Book {
    int id;
    string type;
    string writer;
    string description;
    string publishedDate;
    int numberOfRead;
    vector<Book> books;

    public Book (int id, string type, string writer, string description) {
        this.id = id;
        this.type = type;
        this.writer = writer;
        this.description = description;
        this.publishedDate = CurrentDate();
        this.numberOfRead = 0;
    }

    public void addNewBook(Book book) {
        books.push_back(book);
    }

    public void openBook(Book book) {
        // use internal/external reader to read this book
        book.numberOfRead = book.numberOfRead + 1;
    }

    public void deleteBook(Book book) {
        books.delete(book);
    }

    // search by id
    public static Book searchBook(int id) {
        for(Book book : books) {
            if(book.id == id) {
                return book;
            }
        }
        return NULL;
    }

    // search by writer
    public static Book searchBook(String writer) {
        for(Book book : books) {
            if(book.writer == writer) {
                return book;
            }
        }
        return NULL;
    }
};

public class Reader {
    int id;
    string name;
    string memberSince;
    string validayOfSubscription;
    vector<Reader> readers;

    public Reader(int id, int name, string validayOfSubscription = Yesterday) {
        this.id = id;
        this.name = name;
        this.validayOfSubscription = validayOfSubscription;
        this.memberSince = CurrentDate();
    }

    public void renewSubscription(Reader reader, string newSubscriptionDate) {
        reader.validayOfSubscription = newSubscriptionDate;
    }

    public void addNewReader(Reader reader) {
        readers.push_back(reader);
    }

    public void deleteReader(Reader reader) {
        readers.delete(reader);
    }

    public Reader findReaderById(int id) {
        for(Reader reader : readers) {
            if(reader.id == id) {
                return reader;
            }
        }
        return NULL;
    }
};

public void OnlineReaderSystem() {
    private Book book;
    private Reader reader;

    public OnlineReaderSystem(Book b, Reader r) {
        this.book = b;
        this.reader = r;
    }

    Book searchBook(int id) {
        book.searchBook(id);
    }

    Book searchReader(int id) {
        reader.findReaderById(id);
    }

    public void setBook(Book book) {
        this.book = book;
    }

    Book getBook() {
        return book;
    }

    public void setReader(Reader reader) {
        this.reader = reader
    }

    Reader getReader() {
        return reader;
    }
}
