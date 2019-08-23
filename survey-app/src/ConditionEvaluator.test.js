import {evaluateCondition} from './ConditionEvaluator';
var assert = require('chai').assert

it('returns false for broken input', () => {
    const result = evaluateCondition("", 1);
    assert.equal(false, result);
});
