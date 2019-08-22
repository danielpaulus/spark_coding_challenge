import React, { Component } from 'react'
import SingleChoiceQuestion from './SingleChoiceQuestion'
import SingleChoiceConditionalQuestion from './SingleChoiceConditionalQuestion'

class Question extends Component{

render(){
    const title = <h3>{this.props.details.question} </h3>;
    var questionType = '';
    switch (this.props.details.question_type.type){
    case 'single_choice':
         questionType = <SingleChoiceQuestion questionIndex={this.props.questionIndex} options={this.props.details.question_type.options}/>;
         break;
    case 'single_choice_conditional':
    questionType = <SingleChoiceConditionalQuestion condition={this.props.details.question_type.condition} questionIndex={this.props.questionIndex} options={this.props.details.question_type.options}/>;
             break;
     case 'number_range':
        questionType = <p>number range</p>;
                 break;
    }
    return  <div> {title} {questionType} </div>

}
}

export default Question