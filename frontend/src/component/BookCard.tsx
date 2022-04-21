import {Book} from "../model/Book";

type BookProps = {
    book : Book;
}

export default function BookCard({book} : BookProps){
    return <div>
        <div className="bookText">{book.isbn}</div>
        <div className="bookText" >{book.name}</div>
    </div>
}