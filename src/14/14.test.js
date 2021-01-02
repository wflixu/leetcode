const longestCommonPrefix = require('./14.js');

test('["flower","flow","flight"]', () => {
    expect(longestCommonPrefix(["flower","flow","flight"])).toBe('fl');
});

// ["dog","racecar","car"]
test('["dog","racecar","car"]', () => {
    expect(longestCommonPrefix(["dog","racecar","car"])).toBe('');
});