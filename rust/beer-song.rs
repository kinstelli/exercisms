pub fn verse(n: u32) -> String {
    if n > 2 {
        format!(
            "{} bottles of beer on the wall, {} bottles of beer.\n\
            Take one down and pass it around, {} bottles of beer on the wall.\n",
            n,
            n,
            (n - 1)
        )
    } else if n == 2 {
        format!(
            "{} bottles of beer on the wall, {} bottles of beer.\n\
            Take one down and pass it around, 1 bottle of beer on the wall.\n",
            n, n
        )
    } else if n == 1 {
        format!(
            "1 bottle of beer on the wall, 1 bottle of beer.\n\
            Take it down and pass it around, no more bottles of beer on the wall.\n"
        )
    } else {
        format!(
            "No more bottles of beer on the wall, no more bottles of beer.\n\
            Go to the store and buy some more, 99 bottles of beer on the wall.\n"
        )
    }
}

pub fn sing(start: u32, end: u32) -> String {
    let mut fullsong: String = String::new();
    for i in (end..=start).rev() {
        fullsong += &verse(i);
        if i > end {
            fullsong += "\n";
        }
    }
    fullsong
}
