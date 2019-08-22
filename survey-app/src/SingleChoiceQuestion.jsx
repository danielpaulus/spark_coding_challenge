import React, {Component} from 'react';

class SingleChoiceQuestion extends Component {

  handleClick = (e) => {
          this.props.onDataChange(e.target.id, e.target.value);
          }

  render() {
    const options = this.props.options.map( (option, index) =>
      <div>
        <input onClick={this.handleClick} type="radio" id={this.props.questionIndex+'_'+index} name={this.props.questionIndex} value={index} />
        <label for={this.props.questionIndex+'_'+index}>{option}</label>
      </div>

    );
    return <div>{options}</div>;
  }
}
export default SingleChoiceQuestion;


