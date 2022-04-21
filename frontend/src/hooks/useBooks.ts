import {useEffect, useState} from "react";
import {Book} from "../model/Book"

export default function useBooks(){
    const [fetchedBooks, setFetchedBooks] = useState<Book[]>([])

    const fetchCharacters = () => {
        return fetch('http://localhost:8080/book/all')
            .then(response => {
                if (response.ok) {
                    return response.json()
                }
                throw new Error("Network error")
            }).catch(console.error)
    }

    useEffect(() => {
        fetchCharacters()
            .then(body => {
                setFetchedBooks(body)
                console.log(body)
            })
    }, [])

    return fetchedBooks
}