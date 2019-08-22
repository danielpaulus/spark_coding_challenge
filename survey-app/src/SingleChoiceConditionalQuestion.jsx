import React, { Component } from 'react'
import { evaluateCondition } from './ConditionEvaluator'
import  Question from './Question'

class SingleChoiceConditionalQuestion extends Component{

constructor() {
    super();
    this.state = {
      extraQuestionVisible: false
    }
  }

render(){
const handleClick = (e) => {

    if (evaluateCondition(this.props.condition.predicate, e.target.value)){
        this.setState(() => ({ extraQuestionVisible: true }));
    } else {
    this.setState(() => ({ extraQuestionVisible: false }));
    }
  }

const options = this.props.options.map( (option, index) =>
    <div>
        <input  onClick={handleClick} type="radio" id={this.props.questionIndex+'_'+index} name={this.props.questionIndex} value={option} />
        <label for={this.props.questionIndex+'_'+index}>{option}</label>
    </div>
    );
return <div><p>conditional</p>{options}
        {
          this.state.extraQuestionVisible
                    ? <Question questionIndex={this.props.questionIndex+'extra'} details={this.props.condition.if_positive}/>
                    : null
                }
        </div>
}

}
export default SingleChoiceConditionalQuestion



