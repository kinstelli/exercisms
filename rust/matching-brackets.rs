fn openbrack_for_closebrack(brack: char) -> char {
    match brack {
        ']' => '[',
        '}' => '{',
        ')' => '(',
        _ => 'x',
    }
}

pub fn brackets_are_balanced(the_str: &str) -> bool {
    let mut brack_stack = String::new();
    let open_br = ['{', '(', '['];
    let close_br = ['}', ')', ']'];
    for x in the_str.chars() {
        if open_br.contains(&x) {
            brack_stack.push(x)
        } else if close_br.contains(&x) {
            if brack_stack.pop() != Some(openbrack_for_closebrack(x)) {
                return false;
            }
        }
    }
    brack_stack.is_empty()
}
