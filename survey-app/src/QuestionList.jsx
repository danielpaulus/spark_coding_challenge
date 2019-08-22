import React, {Component} from 'react';
import Question from './Question';
import Category from './Category';

class QuestionList extends Component {
  render() {
    return <div>
      <Category title={this.props.category}/>
      <div>
        {
          this.props.questions
              .map( (question, index) => {
                if (question.category === this.props.category) {
                  return <Question onDataChange={this.props.onDataChange} questionIndex={index} details={question}/>;
                }
              }
              )
        }
      </div>
      <hr />
    </div>;
  }
}

export default QuestionList;
