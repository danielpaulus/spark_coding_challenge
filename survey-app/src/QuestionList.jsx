import React, { Component } from 'react'
import Question from './Question'

class QuestionList extends Component{

render(){
console.log(this.props.questions.filter(question => question.category === this.props.category));
    return  <div><h2>Category {this.props.category}</h2> <div>{this.props.questions.filter(question => question.category === this.props.category).map(question => {
                return <Question details={question}/>
            })}</div></div>;
}
}

export default QuestionList