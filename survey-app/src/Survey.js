import React, {Component} from 'react';
import QuestionList from './QuestionList';
class Survey extends Component {

  onDataChange = (key, value) => {
  console.log(`Change:${key}-->${value}`);
  }

  render() {
    return this.props.categories.map((category) => {
      return <QuestionList onDataChange={this.onDataChange} questions={this.props.survey.questions} category={category}/>;
    });
  }
}

export default Survey;
