const isValid = require('./20.js');

test('() is true', () => {
    expect(isValid('()')).toBe(true);
});

// ()[]{}
test('()[]{} is true', () => {
    expect(isValid('()[]{}')).toBe(true);
});


// (]
test('(] is false', () => {
    expect(isValid('(]')).toBe(false);
});

// ([)]
test('([)] is false',()=>{
    expect(isValid('([)]')).toBe(false);
})

// {[]}
test('{[]} is treu', ()=>{
    expect(isValid('{[]}')).toBe(true);
})