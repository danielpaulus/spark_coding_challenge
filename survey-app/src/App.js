import React, { Component } from 'react';
import './App.css';
import Survey from './Survey';

class App extends Component {

 state = {
    categories : [],
    survey : {}

 }
 componentDidMount() {
        fetch('/api/surveys')
        .then(res => res.json())
        .then((data) => {
          this.setState({ survey: data[0] });
        })
        .catch(console.log)

        fetch('/api/categories')
                .then(res => res.json())
                .then((data) => {
                  this.setState({ categories: data });
                })
                .catch(console.log)
      }

render(){
  return (
    <div className="App">
      <header className="App-header">
      {
                this.state.categories.length>0 && Object.entries(this.state.survey).length>0
                          ? <Survey categories={this.state.categories} survey={this.state.survey}/>
                          : null
            }

      </header>
    </div>
  );}

}

export default App;
