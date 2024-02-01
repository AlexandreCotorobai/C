grammar adv;

program:
    alphabet_dec NEWLINE
    (automaton_dec NEWLINE)+
    (view_dec NEWLINE)+
    (animation_dec NEWLINE)+
    statement* EOF
    ;

statement:
    play_stat NEWLINE
    | NEWLINE
    ;

alphabet_dec:
    'alphabet' '{' (ALPHABET',')* ALPHABET '}'
    ;

automaton_dec:
    AUTOMATA_MODIFIERS? AUTOMATA_TYPES ID '<<<' ('\t' automaton_expr';' | NEWLINE)* '>>>'
    ;

automaton_expr:
    automaton_state_dec_expr
    | automaton_state_prop
    | transition_dec_expr
    ;

automaton_state_dec_expr:
    'state' (STATE ',')* STATE
    |
    ;

automaton_state_prop:
    STATE automaton_state_assign_expr #automaton_state_prop_expr
    | 'for' ID 'in' '{{' (STATE ',')* STATE '}}' ID automaton_state_assign_expr #automaton_state_for_expr
    ;

automaton_state_assign_expr:
    '[' STATE_PROPERTY '=' BOOLEAN ']'
    ;

transition_dec_expr:
    'transition' (transition_def_expr ',')* transition_def_expr
    ;

transition_def_expr:
    STATE '->' (ALPHABET',')* ALPHABET '->' STATE
    ;

view_dec:
    'view' ID 'of' ID '<<<' ('\t' view_expr';' | NEWLINE)* '>>>'
    ;

view_expr:
    place_expr
    | point_decl
    | point_assign_expr
    | transition_decl_expr
    | location_decl_expr
    | grid_decl
    ;

place_expr:
    place_state_expr
    | place_label_expr
    ;

place_state_expr:
    'place' (STATE 'at' coords_expr ',')* STATE 'at' coords_expr
    ;

place_label_expr:
    'place' state_combo label_expr
    ;

state_combo : '<' STATE ',' STATE '>';

label_expr:
    '#lable ' label_prop 'at' ID
    ;


point_decl:
    'point' (ID ',')* ID # point_decl_expr
    | 'point' point_assign_expr # point_decl_assign_expr
    ;

point_assign_expr:
    ID '=' coords_expr
    ;

transition_decl_expr:
    state_combo 'as' (ID LINE_TYPE)* ID
    ;

location_decl_expr:
    state_combo '#lable' label_prop
    ;

grid_decl:
    'grid' ID '('NUMBER','NUMBER')' '[' (grid_prop',')* grid_prop ']'
    ;

grid_prop:
    'step' '=' NUMBER # grid_cell_prop
    | 'margin' '=' NUMBER # grid_height_prop
    | 'color' '=' LETTER+ # grid_color_prop
    | 'line' '=' LETTER+ # grid_line_prop
    ;

label_prop:
    '[' 'align' '=' Y_ALIGN ' ' X_ALIGN ']' # label_prop_align_yx_expr
    | '[' 'align' '=' X_ALIGN ']' # label_prop_align_x_expr
    | '[' 'align' '=' Y_ALIGN ']' # label_prop_align_y_expr
    ;
    
coords_expr:
    '(' coords_expr ')' # coords_paren_expr
    | coords_expr '/' NUMBER    # coords_div_expr
    | coords_expr '*' NUMBER    # coords_mul_expr
    | coords_expr '+' coords_expr # coords_add_expr
    | coords_expr '-' coords_expr # coords_sub_expr
    | coords            # coords_number_expr
    | ID                # coords_id_expr
    | '('STATE')'      # coords_state_expr
    ;

coords:
    '(' NUMBER ',' NUMBER ')' # coords_cartesian_expr
    | '(' NUMBER ':' NUMBER ')' # coords_radial_expr
    ;


animation_dec:
    'animate' ID '<<<' ('\t' animation_expr';' | NEWLINE)* '>>>'
    ;

animation_expr:
    viewport_decl
    | on_viewport
    ;

viewport_decl:
    'viewport' ID 'for' ID 'at' '(' NUMBER ',' NUMBER ')' '--' '++(' NUMBER ',' NUMBER ')'
    ;

on_viewport:
    'on' ID '<<<' ('\t' viewport_expr';' | NEWLINE)* '>>>'
    ;

viewport_expr:
    show_stat 
    | pause_expr
    | str_input_expr
    | state_expr
    | for_expr
    ;

pause_expr:
    'pause'
    ;

str_input_expr:
    'string' ID '=' 'read' '['prompt_expr']'
    ;

prompt_expr:
    'prompt' '=' '"' .*? '"' ']'
    ;

state_expr:
    'state' ID '=' STATE
    ;  

play_stat:
    'play' ID
    ;

for_expr:
    'for' ID 'in' (ID | '{{' (STATE ',')* STATE '}}')  '<<<' viewport_expr '>>>'
    ;

show_stat:
    'show' (show_expr ',')* show_expr (STATE_PROPERTY)?
    ;

show_expr:
    STATE # show_expr_state
    | state_combo # show_expr_state_combo
    | ID # show_expr_id
    ;

// GENERAL USAGE
ID : [a-zA-Z_][a-zA-Z_0-9]*;

LETTER: [a-zA-Z];

ALPHABET : ('\''[a-zA-Z0-9]'\'');

LINE_TYPE: '--' | '..';

NUMBER: [0-9]+('.'[0-9]+)?;

// AUTOMATA
AUTOMATA_TYPES : 'DFA' | 'NFA';
AUTOMATA_MODIFIERS : 'complete';
STATE : [a-zA-Z0-9];
STATE_PROPERTY : 'initial' | 'accepting';
BOOLEAN : 'true' | 'false';

// VIEW
Y_ALIGN: 'below' | 'above';
X_ALIGN: 'left' | 'right';

// WHITESPACE

NEWLINE :'\n';
WS : [ \t\r\n]+ -> skip;

// COMMENTS

COMMENT: ('//' .*? '\n' | '/*' .*? '*/') -> skip;