fn is_all_caps(message: &str) -> bool {
    has_letters(message) && message.to_uppercase() == message
}

fn has_letters(message: &str) -> bool {
    return message.chars().filter(|x| x.is_alphabetic()).count() > 0;
}

pub fn reply(message: &str) -> &str {
    let m = message.trim();
    let mut the_reply: &str = "Whatever.";
    if is_all_caps(m) && m.ends_with("?") {
        the_reply = "Calm down, I know what I'm doing!";
    } else if m.ends_with("?") {
        the_reply = "Sure.";
    } else if is_all_caps(m) {
        the_reply = "Whoa, chill out!";
    } else if m.trim().is_empty() {
        the_reply = "Fine. Be that way!"
    }
    the_reply
}
