import React, { Component } from 'react'
import Slider from 'react-rangeslider'

class NumberRangeQuestion extends Component{

constructor() {
    super();
    this.state = {
      value: 3
    }

  }


handleChange = (value) => {
  this.setState({value: value});

  this.props.onDataChange("slider", value);
}

render() {
console.log(this.props);
  return (
  <div className="slider">
     <Slider
          min={this.props.range.from} max={this.props.range.to}
          value={this.state.value}
          onChange={this.handleChange}
          step={1}/>
  </div>

  );
}

}

export default NumberRangeQuestion