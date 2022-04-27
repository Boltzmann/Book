import {Book} from "../model/Book";
import "./BookCard.css"

type BookProps = {
    book : Book;
}

export default function BookCard({book} : BookProps){
    return <div id="card">
        <div className="bookText">{book.isbn}</div>
        <div className="bookText" >{book.name}</div>
    </div>
}