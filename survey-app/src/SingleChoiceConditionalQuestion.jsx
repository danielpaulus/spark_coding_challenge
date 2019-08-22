import React, { Component } from 'react'

class SingleChoiceConditionalQuestion extends Component{


render(){
const handleClick = (e) => {
    console.log('The link was clicked.');
  }

const options = this.props.options.map( (option, index) =>
    <div>
        <input  onClick={handleClick} type="radio" id={this.props.questionIndex+'_'+index} name={this.props.questionIndex} value={index} />
        <label for={this.props.questionIndex+'_'+index}>{option}</label>
    </div>

    );
return <div><p>conditional</p>{options}</div>
}

}
export default SingleChoiceConditionalQuestion



