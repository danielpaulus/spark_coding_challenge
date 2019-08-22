import React, {Component} from 'react';
import Question from './Question';
import Category from './Category';

class QuestionList extends Component {
  render() {
    return <div>
      <Category title={this.props.category}/>
      <div>
        {
          this.props.questions.filter((question) => question.category === this.props.category)
              .map( (question, index) => {
                return <Question onDataChange={this.props.onDataChange} questionIndex={index} details={question}/>;
              }
              )
        }
      </div>
    </div>;
  }
}

export default QuestionList;
