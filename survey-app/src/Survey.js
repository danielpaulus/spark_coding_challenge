import React, {Component} from 'react';
import QuestionList from './QuestionList';
class Survey extends Component {
  render() {
    return this.props.categories.map((category) => {
      return <QuestionList questions={this.props.survey.questions} category={category}/>;
    });
  }
}

export default Survey;
