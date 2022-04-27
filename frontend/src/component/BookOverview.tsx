import useBooks from "../hooks/useBooks";
import BookList from "./BookList";

export default function BookOverview(){

    const books = useBooks()

    return (
        <div>
            <BookList books={books}/>
        </div>
    )
}