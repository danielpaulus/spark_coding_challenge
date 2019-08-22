import React, { Component } from 'react'

class SingleChoiceQuestion extends Component{

render(){
const options = this.props.options.map( (option, index) =>
    <div>
        <input type="radio" id={this.props.questionIndex+'_'+index} name={this.props.questionIndex} value={index} />
        <label for={this.props.questionIndex+'_'+index}>{option}</label>
    </div>

    );
return <div>{options}</div>
}

}
export default SingleChoiceQuestion



