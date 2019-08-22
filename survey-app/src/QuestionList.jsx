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
                  return <Question key={'question_'+index} onDataChange={this.props.onDataChange} questionIndex={index} details={question}/>;
                }
                return '';
              }
              )
        }
      </div>
      <hr />
    </div>;
  }
}

export default QuestionList;
