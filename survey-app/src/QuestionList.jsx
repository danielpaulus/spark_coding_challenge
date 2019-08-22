import React, {Component} from 'react';
import Question from './Question';

class QuestionList extends Component {
  render() {
    return <div><h2>Category {this.props.category}</h2> <div>{this.props.questions.filter((question) => question.category === this.props.category).map( (question, index) => {
      return <Question questionIndex={index} details={question}/>;
    })}</div></div>;
  }
}

export default QuestionList;
