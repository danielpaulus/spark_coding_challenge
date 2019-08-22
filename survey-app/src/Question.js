import React, { Component } from 'react'
import SingleChoiceQuestion from './SingleChoiceQuestion'
class Question extends Component{

render(){
    const title = <h3>{this.props.details.question} </h3>;
    var questionType = '';
    switch (this.props.details.question_type.type){
    case 'single_choice':
         questionType = <SingleChoiceQuestion questionIndex={this.props.questionIndex} options={this.props.details.question_type.options}/>;
         break;
    case 'single_choice_conditional':
    questionType = <p>single_choice_conditional</p>;
             break;
    }
    return  <div> {title} {questionType} </div>

}
}

export default Question