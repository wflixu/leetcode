const testFn = require('./37.js');

test('III to equal 3', () => {
    expect(testFn("III")).toBe(3);
});


test('IV to equal 4', () => {
    expect(testFn("IV")).toBe(4);
});


test('IX to equal 9', () => {
    expect(testFn("IX")).toBe(9);
});


test('LVIII to equal 58', () => {
    expect(testFn("LVIII")).toBe(58);
});

// MCMXCIV
test('MCMXCIV to equal 1994', () => {
    expect(testFn("MCMXCIV")).toBe(1994);
});