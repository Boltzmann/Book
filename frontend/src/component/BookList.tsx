import {Book} from "../model/Book";
import BookCard from "./BookCard";

type BookListProps = {
    books : Book[]
}

export default function BookList({books}:BookListProps){
    return <div id="bookList">
        <div>
            {books.length > 0 ?
                (<div id="gallery-cards"> {books.map(book => <BookCard book={book}/>)} </div>) :
                (<div>No Book</div>)
            }
        </div></div>
}