import React, {Component} from 'react';
import {evaluateCondition} from './ConditionEvaluator';
import Question from './Question';

class SingleChoiceConditionalQuestion extends Component {
  constructor() {
    super();
    this.state = {
      extraQuestionVisible: false,
    };
  }

handleClick = (e) => {
        this.props.onDataChange(e.target.id, e.target.value);
      if (evaluateCondition(this.props.condition.predicate, e.target.value)) {
        this.setState(() => ({extraQuestionVisible: true}));
      } else {
        this.setState(() => ({extraQuestionVisible: false}));
      }
    };

  render() {
    const options = this.props.options.map( (option, index) =>
      <div>
        <input onClick={this.handleClick} type="radio" id={this.props.questionIndex+'_'+index} name={this.props.questionIndex} value={option} />
        <label for={this.props.questionIndex+'_'+index}>{option}</label>
      </div>
    );
    return <div>{options}
      {
          this.state.extraQuestionVisible
                    ? <Question onDataChange={this.props.onDataChange} questionIndex={this.props.questionIndex+'extra'} details={this.props.condition.if_positive}/>
                    : null
      }
    </div>;
  }
}
export default SingleChoiceConditionalQuestion;


