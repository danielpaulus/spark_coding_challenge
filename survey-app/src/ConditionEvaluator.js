

export function evaluateCondition(predicate, selection) {
  // eslint-disable-next-line
  const selectionKey = '${selection}';
  if (Array.isArray(predicate.exactEquals) && predicate.exactEquals.length === 2) {
    if (predicate.exactEquals[0] === selectionKey ) {
      if (predicate.exactEquals[1] === selection) {
        return true;
      }
    }
  }
  return false;
}
