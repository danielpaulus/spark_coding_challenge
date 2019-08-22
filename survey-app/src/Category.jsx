import React, {Component} from 'react';

const displayNames = {'hard_fact': 'Hard Fact',
  'lifestyle': 'LifeStyle',
  'introversion': 'Introversion',
  'passion': 'Passion'};

class Category extends Component {
  render() {
    return <h1>{displayNames[this.props.title]}</h1>;
  }
}

export default Category;
