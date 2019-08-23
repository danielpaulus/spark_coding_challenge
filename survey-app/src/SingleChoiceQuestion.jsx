import React, {Component} from 'react';

class SingleChoiceQuestion extends Component {

  handleClick = (e) => {
          this.props.onDataChange(e.target.id, parseInt(e.target.value));
          }

  render() {
    const options = this.props.options.map( (option, index) =>
      <div className="form-group">
        <input className="form-control" required onClick={this.handleClick} type="radio" id={'q'+this.props.questionIndex} name={this.props.questionIndex} value={index} />
        <label htmlFor={this.props.questionIndex+'_'+index}>{option}</label>
      </div>

    );
    return <div  className="card-body">{options}</div>;
  }
}
export default SingleChoiceQuestion;


