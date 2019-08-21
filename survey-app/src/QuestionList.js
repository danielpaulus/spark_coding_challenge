import React, { Component } from 'react'

class QuestionList extends Component{

render(){
    return <h2>Category {this.props.category}</h2>;
}
}

export default QuestionList