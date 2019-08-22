import React, {Component} from 'react';
import QuestionList from './QuestionList';
class Survey extends Component {

constructor() {
    super();
    this.state = {
        answers : {}
    }

  }

  onDataChange = (key, value) => {
  console.log(`Change:${key}-->${JSON.stringify(value)}`);
  this.setState( oldState =>{
    const clonedAnswers = {...oldState.answers};
    clonedAnswers[key] = value;
    return {answers: clonedAnswers};
  });
  }

submitForm = (e) =>{
    e.preventDefault();
    console.log(this.state);
    console.log(e);
    fetch('/api/response', {
       method: 'post',
       headers: {
                   'Content-Type': 'application/json',
               },
       body: JSON.stringify(this.state)
      }).then(res => console.log(res));
}

  render() {
    const questions = this.props.categories.map((category) => {
                            return <QuestionList key={'qlist_'+category} onDataChange={this.onDataChange} questions={this.props.survey.questions} category={category}/>
                          });
    return <form onSubmit={this.submitForm}>{questions}<button type="submit">Submit</button></form>
  }
}

export default Survey;
