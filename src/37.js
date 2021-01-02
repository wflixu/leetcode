const store = {
    "I":1,
    "V":5,
    "X":10,
    "L":50,
    "C":100,
    "D":500,
    "M":1000
}

/**
 * @param {string} s
 * @return {number}
 */
let romanToInt = function(s) {
   let res = 0;
   for (let index = 0; index < s.length; index++) {
      let cur = store[s[index]];
      let next = store[s[index+1]];
      if(next && cur<next){
          res = res - cur;
      }else {
          res = res+cur;
      } 
    
   }
   return res;
};


module.exports = romanToInt;



