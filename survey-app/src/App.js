import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Survey from './Survey';
const apiUrl = 'http://localhost:4000';
class App extends Component {

 state = {
    categories : [],
    survey : {}

 }
 componentDidMount() {
        fetch(`${apiUrl}/surveys`)
        .then(res => res.json())
        .then((data) => {
          this.setState({ survey: data[0] })
        })
        .catch(console.log)

        fetch(`${apiUrl}/categories`)
                .then(res => res.json())
                .then((data) => {
                  this.setState({ categories: data })
                })
                .catch(console.log)
      }

render(){
  return (
    <div className="App">
      <header className="App-header">
            <h1></h1>
            <Survey categories={this.state.categories} survey={this.state.survey}/>
      </header>
    </div>
  );}

}

export default App;
