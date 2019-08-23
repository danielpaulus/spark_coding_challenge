import {evaluateCondition} from './ConditionEvaluator';
const assert = require('chai').assert;

it('returns false for broken input', () => {
  const result = evaluateCondition('', 1);
  assert.equal(false, result);
});
