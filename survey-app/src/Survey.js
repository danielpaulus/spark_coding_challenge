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
}

  render() {
    const questions = this.props.categories.map((category) => {
                            return <QuestionList onDataChange={this.onDataChange} questions={this.props.survey.questions} category={category}/>
                          });
    return <form>{questions}<button onClick={this.submitForm}>submit</button></form>
  }
}

export default Survey;
