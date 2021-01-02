/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  let dict = new Map();
  dict.set('(',')');
  dict.set('[',']');
  dict.set('{','}');
  let stack = [];
  
  for (let i = 0; i <s.length;i++){
      if(dict.has(s[i])) {
          stack.push(s[i]);
      }else{
        if(stack.length === 0){
            return false;
        }else {
            if(dict.get(stack[stack.length - 1]) === s[i]){
                stack.pop();
            }else {
                return false;
            }
        }
      }
  }
  return !stack.length;

};


module.exports =isValid;