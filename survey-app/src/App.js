import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Survey from './Survey';

class App extends Component {

 componentDidMount() {
        fetch('http://jsonplaceholder.typicode.com/users')
        .then(res => res.json())
        .then((data) => {
          this.setState({ contacts: data })
        })
        .catch(console.log)
      }

render(){
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
              <p>
                Etdd <code>src/App.js</code> and save to reload.
              </p>

            <Survey surveyData={this.state.surveyData}/>
      </header>
    </div>
  );}

}

export default App;
