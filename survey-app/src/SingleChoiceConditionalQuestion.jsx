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
       this.props.onDataChange(e.target.id, {'a':parseInt(e.target.value)});
       const currentOption = {id: e.target.id, answer: {'a':parseInt(e.target.value)}}
       const selectedOption = e.target.getAttribute('option')
      if (evaluateCondition(this.props.condition.predicate, selectedOption)) {
        this.setState(() => ({extraQuestionVisible: true, currentOption:currentOption }),
        ()=>this.changeEmbeddedQuestionData({'key': "extra", 'value': 18})
        );

      } else {
        this.setState(() => ({extraQuestionVisible: false}));
      }
    };

changeEmbeddedQuestionData = (changedValue) => {
 const id = this.state.currentOption.id;
 const selectedAnswer = this.state.currentOption.answer;
 selectedAnswer[changedValue.key] = parseInt(changedValue.value);
 this.props.onDataChange(id, selectedAnswer);
}

  render() {
    const options = this.props.options.map( (option, index) =>
      <div>
        <input required onClick={this.handleClick} type="radio" id={'q'+this.props.questionIndex} name={this.props.questionIndex} option={option} value={index} />
        <label htmlFor={this.props.questionIndex+'_'+index}>{option}</label>
      </div>
    );
    return <div>{options}
      {
          this.state.extraQuestionVisible
                    ? <Question onDataChange={this.changeEmbeddedQuestionData} questionIndex={this.props.questionIndex+'extra'} details={this.props.condition.if_positive}/>
                    : null
      }
    </div>;
  }
}
export default SingleChoiceConditionalQuestion;


