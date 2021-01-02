/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
   let len = strs[0].length;
   let res = '';
   for (let i = 0; i < len; i++) {
     let char = strs[0][i];
     if(!char){
         break;
     }

     let isAll = strs.every(item=>{
       return item[i] === char;
     });
     if(!isAll) {
         break;
     }else {
         res+=char;
     }
   }
   return res;
};

module.exports = longestCommonPrefix;