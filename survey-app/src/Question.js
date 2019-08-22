import React, {Component} from 'react';
import SingleChoiceQuestion from './SingleChoiceQuestion';
import SingleChoiceConditionalQuestion from './SingleChoiceConditionalQuestion';
import NumberRangeQuestion from './NumberRangeQuestion';

class Question extends Component {
  render() {
    const title = <h3>{this.props.details.question} </h3>;
    let questionType = '';
    switch (this.props.details.question_type.type) {
      case 'single_choice':
        questionType = <SingleChoiceQuestion onDataChange={this.props.onDataChange} questionIndex={this.props.questionIndex} options={this.props.details.question_type.options}/>;
        break;
      case 'single_choice_conditional':
        questionType = <SingleChoiceConditionalQuestion onDataChange={this.props.onDataChange} condition={this.props.details.question_type.condition} questionIndex={this.props.questionIndex} options={this.props.details.question_type.options}/>;
        break;
      case 'number_range':
        questionType = <NumberRangeQuestion onDataChange={this.props.onDataChange} questionIndex={this.props.questionIndex} range={this.props.details.question_type.range}/>;
        break;
    }
    return <div> {title} {questionType} </div>;
  }
}

export default Question;
