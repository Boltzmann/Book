import React from 'react';
import './App.css';
import BookOverview from './component/BookOverview';
import Title from "./component/Title";
import AddBook from "./component/AddBook";

function App() {
  return (
    <div className="App">
      <header className="App-header">

      </header>
      <Title/>
        <BookOverview />
        <AddBook />
    </div>
  );
}

export default App;
