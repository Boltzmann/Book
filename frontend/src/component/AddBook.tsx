import {ChangeEvent, useState} from "react";
import {Book} from "../model/Book";

export default function AddBook(){

    const [name, setName] = useState('');
    const [isbn, setIsbn] = useState('');

    const handleSubmit = (event:any) => {
        event.preventDefault()
        alert('A book was submitted: ' + name);
        const book:Book = {isbn, name}
        console.log(book)
    };



    const handleNameChange = (event:ChangeEvent<HTMLInputElement>) => {
        setName(event.target.value);
    };

    const handleIdChange = (event:ChangeEvent<HTMLInputElement>) => {
        setIsbn(event.target.value);
    };

    return (
        <div className="book-form">
            <h1>
                Neues Buch anlegen
            </h1>
            <form onSubmit={handleSubmit}>
                <label>Your Sandwich</label>
                <input type={"text"} required value={name} onChange={handleNameChange } />
                <input type={"text"} required value={isbn} onChange={handleIdChange } />
                <input type="submit" value="Anlegen" />
            </form>
        </div>
    )
}